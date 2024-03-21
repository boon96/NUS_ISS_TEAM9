import React from 'react';
import { Typography, Row, Col, Divider, List, Avatar } from 'antd';
import { EnvironmentOutlined, HeartOutlined, CheckOutlined } from '@ant-design/icons';

const { Title, Paragraph } = Typography;

const AboutUsPage = () => {
  return (
    <div style={{ padding: '20px' }}>
      <Row justify="center">
        <Col xs={24} sm={24} md={18} lg={16} xl={14}>
          <Title level={2}>Our Story</Title>
          <Paragraph>
            Nestled along the pristine coastline of the Caribbean, Azure Sands Resort stands as a beacon of serenity and luxury. Inspired by the vibrant hues of the azure sea and the golden sands that stretch as far as the eye can see, this exclusive retreat offers an unparalleled escape for those seeking rejuvenation and indulgence.
          </Paragraph>
          <Divider />

          <Title level={2}>Mission Statement</Title>
          <Paragraph>
            At Azure Sands Resort, our mission is to create unforgettable experiences that elevate the senses and nourish the soul. We are committed to providing impeccable service, luxurious accommodations, and unparalleled amenities amidst the breathtaking beauty of our coastal paradise. Whether you seek relaxation, adventure, or simply a moment of blissful solitude, we strive to exceed your every expectation and leave you with cherished memories that linger long after your departure.
          </Paragraph>
          <Divider />

          <Title level={2}>Amenities</Title>
          <List
            itemLayout="horizontal"
            dataSource={[
              {
                title: 'Luxurious Accommodations',
                icon: <Avatar icon={<EnvironmentOutlined />} />,
                description: 'Choose from elegantly appointed guest rooms, suites, and private villas, each offering breathtaking views of the Caribbean Sea or lush tropical gardens.',
              },
              {
                title: 'Beachfront Infinity Pool',
                icon: <Avatar icon={<HeartOutlined />} />,
                description: 'Immerse yourself in luxury as you soak up the sun beside our infinity pool, overlooking the crystal-clear waters of the Caribbean.',
              },
              {
                title: 'World-Class Dining',
                icon: <Avatar icon={<CheckOutlined />} />,
                description: 'Indulge your palate with delectable cuisine crafted by our talented chefs, featuring locally sourced ingredients and international flavors. Enjoy oceanfront dining at our signature restaurant or savor cocktails and light bites at our beachside bar.',
              },
              // Add more amenities as needed
            ]}
            renderItem={item => (
              <List.Item>
                <List.Item.Meta
                  avatar={item.icon}
                  title={item.title}
                  description={item.description}
                />
              </List.Item>
            )}
          />
        </Col>
      </Row>
    </div>
  );
};

export default AboutUsPage;
