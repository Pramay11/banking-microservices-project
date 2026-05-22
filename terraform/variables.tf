variable "aws_region" {
  default = "ap-south-1"
}

variable "instance_type" {
  default = "t3.medium"
}

variable "ami_id" {
  description = "Amazon Linux 2023 AMI"
}