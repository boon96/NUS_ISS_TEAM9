// import { useQuery } from "@apollo/client";
import React, { useContext, useEffect } from "react";
import { useParams, useLocation } from "react-router";
// import PageError from "../../components/Error/PageError";
// import { PageContainer } from "../../components/GlobalStyles/PageStyles";
// import PageLoader from "../../components/Loaders/PageLoader";
// import { GET_HOTEL_BY_ID } from "../../graphql/queries/hotelQueries";
// import { GlobalContext } from "../../utils/Context";
// import { HotelDetails, ManagerView } from "./HotelDetails";
import SearchItem from "./searchedItem";
import List from "./list";

const Hotel = () => {
    // const {setPage} = useContext(GlobalContext)
    const { id } = useParams();
    const location = useLocation();
    const roomData = location.state?.roomData;
    return (
        <div className="m-8">
        {/* // <PageContainer style={{maxWidth: "1200px", marginLeft: "auto", marginRight: "auto"}}> */}
            {/* <HotelDetails hotel={hotel} params={location.state}/> */}
            {/* <HotelDetails /> */}
            <div className="listItem">
                <List roomData={roomData}/>
            {/* <SearchItem/> */}
            </div>
        {/* // </PageContainer> */}
        {/* <HotelDetails/> */}
        </div>
    );
};

export default Hotel;