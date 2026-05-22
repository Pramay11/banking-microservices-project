resource "aws_vpc" "banking_vpc" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "banking-vpc"
  }
}

resource "aws_subnet" "public_subnet" {
  vpc_id                  = aws_vpc.banking_vpc.id
  cidr_block              = "10.0.1.0/24"
  map_public_ip_on_launch = true

  tags = {
    Name = "banking-public-subnet"
  }
}

resource "aws_internet_gateway" "igw" {
  vpc_id = aws_vpc.banking_vpc.id
}

resource "aws_route_table" "public_rt" {

  vpc_id = aws_vpc.banking_vpc.id

  route {
    cidr_block = "0.0.0.0/0"

    gateway_id = aws_internet_gateway.igw.id
  }
}

resource "aws_route_table_association" "public_assoc" {

  subnet_id      = aws_subnet.public_subnet.id

  route_table_id = aws_route_table.public_rt.id
}

resource "aws_security_group" "banking_sg" {

  name   = "banking-sg"

  vpc_id = aws_vpc.banking_vpc.id

  ingress {

    from_port = 22

    to_port = 22

    protocol = "tcp"

    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {

    from_port = 8080

    to_port = 8085

    protocol = "tcp"

    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {

    from_port = 0

    to_port = 0

    protocol = "-1"

    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_instance" "jenkins_server" {

  ami           = var.ami_id

  instance_type = var.instance_type

  subnet_id = aws_subnet.public_subnet.id

  vpc_security_group_ids = [aws_security_group.banking_sg.id]

  tags = {
    Name = "Banking-DevOps-Server"
  }
}