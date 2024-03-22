import "./searchItem.css";
import React, { useEffect } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";

const SearchItem = () => {
  //to call api
  const dispatch = AppDispatch();
  //to navigate to other page
  const navigate = useNavigate();

  //retrieve details of searched item

  const onClickFunction =() =>{
        navigate('/hotel/confirmation')
  }
  return (
    <div className="searchItem">
      <img
    //   src="../../resources/2bed.png"
        src="https://cf.bstatic.com/xdata/images/hotel/square600/261707778.webp?k=fa6b6128468ec15e81f7d076b6f2473fa3a80c255582f155cae35f9edbffdd78&o=&s=1"
        alt=""
        className="siImg"
      />
      <div className="siDesc">
        <h1 className="siTitle">Tower Street Apartments</h1>
        {/* roomname */}
        <span className="siDistance">500m from center</span>
        <span className="siTaxiOp">Free airport taxi</span>
        <span className="siSubtitle">
          Studio Apartment with Air conditioning
        </span>
        <span className="siFeatures">
          Entire studio • 1 bathroom • 21m² 1 full bed
        </span>
        {/* roomDescription */}
        <span className="siCancelOp">Free cancellation </span>
        <span className="siCancelOpSubtitle">
          You can cancel later, so lock in this great price today!
        </span>
      </div>
      <div className="siDetails">
        <div className="siDetailTexts">
          <span className="siPrice">$112</span> 
          {/* price */}
          <span className="siTaxOp">Includes taxes and fees</span>
          <button className="siCheckButton" onClick={onClickFunction}>See availability</button>
        </div>
      </div>
    </div>
  );
};

export default SearchItem;