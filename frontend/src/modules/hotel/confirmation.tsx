import React from "react";
import { Form, Input, Button, Typography, Card } from 'antd';

const { Title } = Typography;


export const HotelConfirmation = () =>{


    const onFinish = (values) => {
        console.log('Received values:', values);
        // Handle form submission here, such as sending a booking request
      };

    return(
        <div style={{ padding: '20px' }}>
          {/* <Title level={2}>Reservation for Room 'test'</Title> */}
          <Card title="Reservation for Room 'test'" style={{ width: 600, margin: 'auto' }}>
          <Form
            name="reservation-form"
            onFinish={onFinish}
            layout="vertical"
            labelCol={{ span: 8 }}
                wrapperCol={{ span: 16 }}
                style={{ maxWidth: 600 }}
          >
            <Form.Item
              label="Name"
              name="name"
              rules={[{ required: true, message: 'Please enter your name' }]}
            >
              <Input />
            </Form.Item>
            <Form.Item
              label="Email Address"
              name="email"
              rules={[
                { required: true, message: 'Please enter your email' },
                { type: 'email', message: 'Please enter a valid email address' },
              ]}
            >
              <Input />
            </Form.Item>
            <Form.Item
              label="Phone Number"
              name="phone"
              rules={[
                { required: true, message: 'Please enter your phone number' },
                { pattern: /^[0-9]{8}$/, message: 'Please enter a valid phone number' },
              ]}
            >
              <Input />
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Form>
          </Card>
        </div>
      );
};
export default HotelConfirmation;