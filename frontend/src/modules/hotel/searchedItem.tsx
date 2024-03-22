import { useEffect } from "react";
import "./searchItem.css";
import axios from "axios";

const SearchItem = () => {

  const fetchAllBooking = async()=>{
    try{
      const url = '/api/booking';
      const response = await  axios.get(url);
      const data = response.data;
      console.log("Booking data is ", data);
    }catch(error){
      console.log("Error fetching all booking", error);
    }
  }

  useEffect(()=>{
    fetchAllBooking();
  },[]);
  //retrieve details of searched item
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
          <button className="siCheckButton">See availability</button>
        </div>
      </div>
    </div>
  );
};

export default SearchItem;