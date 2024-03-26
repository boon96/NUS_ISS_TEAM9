import "./searchItem.css";
import React, { useEffect, useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import axios from "axios";
import ConfirmationModal from "../shared/UI/reservationPopup";
import { DatePicker, InputNumber, Button, Form } from 'antd';
import { mockData } from "src/resources/mockdata";

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
    navigate('/hotel/confirmation')
  }
  return (
    // <div className="searchItem">
    //   <img
    //     //   src="../../resources/2bed.png"
    //     src="https://cf.bstatic.com/xdata/images/hotel/square600/261707778.webp?k=fa6b6128468ec15e81f7d076b6f2473fa3a80c255582f155cae35f9edbffdd78&o=&s=1"
    //     alt=""
    //     className="siImg"
    //   />
    //   <div className="siDesc">
    //     <h1 className="siTitle">Tower Street Apartments</h1>
    //     {/* roomname */}
    //     <span className="siDistance">500m from center</span>
    //     <span className="siTaxiOp">Free airport taxi</span>
    //     <span className="siSubtitle">
    //       Studio Apartment with Air conditioning
    //     </span>
    //     <span className="siFeatures">
    //       Entire studio • 1 bathroom • 21m² 1 full bed
    //     </span>
    //     {/* roomDescription */}
    //     <span className="siCancelOp">Free cancellation </span>
    //     <span className="siCancelOpSubtitle">
    //       You can cancel later, so lock in this great price today!
    //     </span>
    //   </div>
    //   <div className="siDetails">
    //     <div className="siDetailTexts">
    //       <span className="siPrice">$112</span>
    //       {/* price */}
    //       <span className="siTaxOp">Includes taxes and fees</span>
    //       {props.userLoggedIn ? (
    //         <div>
    //           {/* <button className="siCheckButton" onClick={props.handleReservation}>Book Now</button> */}
    //           <Button type="primary" onClick={() => setIsConfirmationVisible(true)}>
    //             Submit Reservation
    //           </Button>
    //           <ConfirmationModal
    //             isVisible={isConfirmationVisible}
    //             onConfirm={props.handleReservation}
    //             onCancel={() => setIsConfirmationVisible(false)}
    //             message="Are you sure you want to submit the reservation?"
    //           />
    //         </div>
    //       ) :
    //         (
    //           <button className="siCheckButton" onClick={props.handleReservation}>See availability</button>
    //         )
    //       }
    //     </div>
    //   </div>
    // </div>
    <div className="searchItemContainer">
    <div className="searchItem">
      {/* Render search item details */}
      {mockData.map((item) => (
        <div key={item.roomId} className="searchItemContent">
          {/* Render room image */}
          <img
            src="https://cf.bstatic.com/xdata/images/hotel/square600/261707778.webp?k=fa6b6128468ec15e81f7d076b6f2473fa3a80c255582f155cae35f9edbffdd78&o=&s=1"
            alt=""
            className="siImg"
          />
          {/* Render room details */}
          <div className="siDesc">
            <h1 className="siTitle">{item.roomTypeId.name}</h1>
            <span className="siDistance">500m from center</span>
            <span className="siTaxiOp">Free airport taxi</span>
            <span className="siSubtitle">{item.status}</span>
            <span className="siFeatures">{item.roomTypeId.description}</span>
            <span className="siCancelOp">Free cancellation</span>
            <span className="siCancelOpSubtitle">You can cancel later, so lock in this great price today!</span>
          </div>
          {/* Render room price and reservation button */}
          <div className="siDetails">
            <div className="siDetailTexts">
              <span className="siPrice">{item.roomTypeId.price}</span>
              <span className="siTaxOp">Includes taxes and fees</span>
              {/* Render different buttons based on user login status */}
              {props.userLoggedIn ? (
                <div>
                  <Button type="primary" onClick={() => setIsConfirmationVisible(true)}>
                    Submit Reservation
                  </Button>
                  <ConfirmationModal
                    isVisible={isConfirmationVisible}
                    onConfirm={props.handleReservation}
                    onCancel={() => setIsConfirmationVisible(false)}
                    message="Are you sure you want to submit the reservation?"
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
     </div>
  );
};

export default SearchItem;