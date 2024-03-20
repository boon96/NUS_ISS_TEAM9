import "./searchItem.css";
import { useLocation } from "react-router-dom";
import React, { useState } from "react";
import { format } from "date-fns";
import { DateRange } from "react-date-range";
import SearchItem from "./searchedItem";
import { Storage } from 'react-jhipster';
import moment, { Moment } from 'moment';
import dayjs, { Dayjs } from 'dayjs';
import { DatePicker, InputNumber, Button } from 'antd';

const List = () => {
    // const location = useLocation();
    //   const [destination, setDestination] = useState(location.state.destination);
    //   const [date, setDate] = useState(location.state.date);
    //   const [openDate, setOpenDate] = useState(false);
    //   const [options, setOptions] = useState(location.state.options);
    const { RangePicker } = DatePicker;
    const checkInDate = Storage.session.get('checkInDate');
    const checkOutDate = Storage.session.get('checkOutDate');
    const adult = Storage.session.get('adults');
    const defaultStartDate = moment(checkInDate, 'DD-MM-YYYY'); // Default start date in DD-MM-YYYY format
    const defaultEndDate = moment(checkOutDate, 'DD-MM-YYYY'); // Default end date in DD-MM-YYYY format

    console.log(checkInDate);
    // const checkInDayjs = dayjs(defaultStartDate);
    // const checkOutDayjs = dayjs(defaultEndDate);

    const [dateRange, setDateRange] = useState([defaultStartDate, defaultEndDate]);
    console.log(adult);

    const dateFormat = 'DD/MM/YYYY';
    // const handleDateChange = (dates: Moment[]) => {
    //     setDateRange(dates);
    //   };

    return (
        <div>
            <div className="listContainer">
                <div className="listWrapper">
                    <div className="listSearch">
                        <h1 className="lsTitle">Search</h1>
                        <div className="lsItem">
                            <label>Check-in Date</label>
                            <span> {checkInDate}  </span>
                            <RangePicker
            //   defaultValue={dateRange.map(date => date.toDate())}
            // defaultValue={[moment("2022-09-12"), moment("2022-09-12",)]}
            />
                            {/* <span onClick={() => setOpenDate(!openDate)}>{`${format(
                date[0].startDate,
                "MM/dd/yyyy"
              )} to ${format(date[0].endDate, "MM/dd/yyyy")}`}</span>
              {openDate && (
                <DateRange
                  onChange={(item) => setDate([item.selection])}
                  minDate={new Date()}
                  ranges={date}
                />
              )} */}
                        </div>
                        <div className="lsItem">
                            <label>Options</label>
                            <div className="lsOptions">
                                <div className="lsOptionItem">
                                    <span className="lsOptionText">
                                        Min price <small>per night</small>
                                    </span>
                                    <InputNumber className="lsOptionInput" />
                                </div>
                                <div className="lsOptionItem">
                                    <span className="lsOptionText">
                                        Max price <small>per night</small>
                                    </span>
                                    <InputNumber className="lsOptionInput" />
                                </div>
                            </div>
                        </div>
                        <button>Search</button>
                    </div>
                    <div className="listResult">
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default List;