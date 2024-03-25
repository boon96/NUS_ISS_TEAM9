import React from "react";
import HotelHeader from "../shared/UI/hotelHeader";
import { Card, Button, Form, notification} from 'antd';
import { useLocation, useNavigate } from 'react-router-dom';
import { Storage } from 'react-jhipster';

export const SummaryPage = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const result = location.state?.data;

   
   const formatDate = (dateString)=> {
    const date = new Date(dateString);
  
    const formattedDate = date.toLocaleDateString('en-GB', {
      day: '2-digit',
      month: '2-digit',
      year: '2-digit'
    });
  
    return formattedDate;
  }

    const checkInDate = formatDate(result.checkInDate);
    const checkOutDate = formatDate(result.checkOutDate);
    
    const handleHomeButtonClick = () => {
        navigate('/'); // Navigate to the home page
    }

    const handlePrintButtonClick = () => {
        window.print(); // Print the current page
    }

    return(
        <section className="m-8">
            <HotelHeader/>
            <Card title="Booking Summary" style={{ width: 600, margin: 'auto' }}>
      <p><strong>Check-in Date:</strong> {checkInDate}</p>
      <p><strong>Check-out Date:</strong> {checkOutDate}</p>
      <p><strong>Booking Reference:</strong> {result.bookId}</p>
      <p><strong>Guest Name:</strong> {result.name}</p> 
      <p><strong>Email:</strong> {result.emailAddress}</p>
      <p><strong>Phone:</strong> {result.phoneNumber}</p>
      <p><strong>Total Price:</strong> {result.totalPrice}</p>
      <div style={{ marginTop: '20px' }}>
                    <Button type="primary" onClick={handleHomeButtonClick}>Home</Button>
                    <Button style={{ marginLeft: '10px' }} onClick={handlePrintButtonClick}>Print</Button>
                </div>
    </Card>
        </section>
    )
    
}

export default SummaryPage;