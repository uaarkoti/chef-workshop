#
# Cookbook Name:: chefconf
# Recipe:: default
#
# Copyright (c) 2014 Udaypal Aarkoti, All Rights Reserved.
#

package 'httpd'

service 'httpd' do
  action [:start, :enable]
end

file '/var/www/html/index.html' do
  content "<h1>hello world</h1>\n"
end
