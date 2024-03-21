import React from "react";
import { Row, Col, Form, Input, Button, Typography } from 'antd';
import { MailOutlined, PhoneOutlined, EnvironmentOutlined } from '@ant-design/icons';

const { Title } = Typography;

export const ContactUsPage = () =>{

    const onFinish = (values) => {
        console.log('Received values:', values);
        // Handle form submission here, such as sending an email
      };
    
      return (
        <div style={{ padding: '20px' }}>
          <Row gutter={[16, 16]}>
            <Col xs={24} sm={24} md={12}>
              <Title level={2}>Contact Information</Title>
              <div>
                <p><PhoneOutlined /> Phone: +1234567890</p>
                <p><MailOutlined /> Email: info@example.com</p>
                <p><EnvironmentOutlined /> Address: 123 Hotel Street, City, Country</p>
              </div>
            </Col>
            <Col xs={24} sm={24} md={12}>
              <Title level={2}>Send Us a Message</Title>
              <Form
                name="contact-form"
                onFinish={onFinish}
                layout="vertical"
              >
                <Form.Item
                  name="name"
                  label="Name"
                  rules={[{ required: true, message: 'Please enter your name' }]}
                >
                  <Input />
                </Form.Item>
                <Form.Item
                  name="email"
                  label="Email"
                  rules={[{ required: true, message: 'Please enter your email' }]}
                >
                  <Input />
                </Form.Item>
                <Form.Item
                  name="message"
                  label="Message"
                  rules={[{ required: true, message: 'Please enter your message' }]}
                >
                  <Input.TextArea />
                </Form.Item>
                <Form.Item>
                  <Button type="primary" htmlType="submit">Submit</Button>
                </Form.Item>
              </Form>
            </Col>
          </Row>
          <Row>
            <Col span={24}>
              {/* Replace the iframe src with your hotel's location */}
              <iframe
                title="hotel-location"
                width="100%"
                height="400"
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3083.881641723456!2d-122.408432684618!3d37.785979779758606!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80858094fd8288ff%3A0x3e9a1ce1e7f3a1bc!2sGolden%20Gate%20Bridge!5e0!3m2!1sen!2sus!4v1624586871519!5m2!1sen!2sus"
              ></iframe>
            </Col>
          </Row>
        </div>
      );
    };
    
    export default ContactUsPage;