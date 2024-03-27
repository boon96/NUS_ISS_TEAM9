import "./searchItem.css";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import axios from "axios";
import ConfirmationModal from "../shared/UI/reservationPopup";
import { DatePicker, InputNumber, Button, Form, notification } from 'antd';
import { mockData } from "src/resources/mockdata";
import { Storage } from 'react-jhipster';

const SearchItem = (props: any) => {
  //to call api
  const dispatch = AppDispatch();
  //to navigate to other page
  const navigate = useNavigate();

  const CheckDate = props.dates;
  const price = props.price;

  console.log("price: ", price);
  console.log("check in and checkout date: ", CheckDate);
  const [isConfirmationVisible, setIsConfirmationVisible] = useState(false);

  // const fetchAllBooking = async()=>{
  //   try{
  //     const url = '/api/booking';
  //     const response = await  axios.get(url);
  //     const data = response.data;
  //     console.log("Booking data is ", data);
  //   }catch(error){
  //     console.log("Error fetching all booking", error);
  //   }
  // }

  // useEffect(()=>{
  //   fetchAllBooking();
  // },[]);
  //retrieve details of searched item

  console.log(mockData)

  const onClickFunction = () => {
    console.log(Storage.session.get('customer'));
    if(Storage.session.get('customer') === null || Storage.session.get('customer') === undefined){
      notification.error({
        message: 'Account missing',
        description: 'Please register an Account or Sign in first.',
    });
    }
  }

  const [isConfirmationVisibleArray, setIsConfirmationVisibleArray] = useState(
    Array(Math.ceil(mockData.length / 3)).fill(false).map(() => Array(3).fill(false))
  );

  // Function to toggle the visibility of the confirmation modal for a specific item
  const toggleConfirmationModal = (roomId, price, rowIndex, itemIndex) => {
    setIsConfirmationVisibleArray((prevState) => {
      const newState = [...prevState];
      newState[rowIndex][itemIndex] = !newState[rowIndex][itemIndex];
      return newState;
    });
  };

  // Function to chunk the mockData into rows of 3 items
  const chunkedData = [];
  for (let i = 0; i < mockData.length; i += 3) {
    chunkedData.push(mockData.slice(i, i + 3));
  }

  return (

    <div className="searchItemContainer">
      {/* Render each row */}
      {chunkedData.map((row, rowIndex) => (
        <div key={rowIndex} className="searchItemRow">
          {/* Render items in the row */}
          {row.map((item, itemIndex) => (
            <div key={item.roomId} className="searchItemContent">
              <img
                src="https://cf.bstatic.com/xdata/images/hotel/square600/261707778.webp?k=fa6b6128468ec15e81f7d076b6f2473fa3a80c255582f155cae35f9edbffdd78&o=&s=1"
                alt=""
                className="siImg"
              />
              <div className="siDesc">
                <h1 className="siTitle">{item.name}</h1>
                <span className="siDistance">500m from airport</span>
                <div className="siFeaturesContainer">

                  <div className="siFeatureLabel">Free airport taxi</div>
                  <div className="siFeatureLabel">Free Wi-Fi</div>
                  <div className="siFeatureLabel">Free breakfast</div>
                  <div className="siFeatureLabel">Swimming pool</div>
                  {/* Add more features as needed */}
                </div>
                <span className="siSubtitle">{item.status}</span>
                <span className="siFeatures">{item.description}</span>
                <span className="siCancelOp">Free cancellation</span>
                <span className="siCancelOpSubtitle">You can cancel later, so lock in this great price today!</span>
              </div>
              <div className="siDetails">
                <div className="siDetailTexts">
                  <span className="siPrice">${item.price * props.daysInHotel}</span>
                  <span className="siTaxOp">Includes taxes and fees</span>
                  {props.userLoggedIn ? (
                    <div>
                      <Button type="primary" onClick={() => toggleConfirmationModal(item.roomId, item.price, rowIndex, itemIndex)}>
                        Submit Reservation
                      </Button>
                      <ConfirmationModal
                        isVisible={isConfirmationVisibleArray[rowIndex][itemIndex]}
                        onConfirm={() => props.handleReservation(item.roomId, item.price)}
                        onCancel={() => toggleConfirmationModal(item.roomId, item.price, rowIndex, itemIndex)}
                        message={`Are you sure you want to submit the reservation for ${item.name}?`}
                      />
                    </div>
                  ) : (
                    <button className="siCheckButton" onClick={onClickFunction}>See availability</button>
                  )}
                </div>
              </div>
            </div>
          ))}
        </div>
      ))}
    </div>
  );
};

export default SearchItem;