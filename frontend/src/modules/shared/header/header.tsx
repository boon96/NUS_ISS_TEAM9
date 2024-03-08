import React from "react";


export const Header = () => {

    return (
    //     <div className="navigation-items--container"><div className="dy-nav-container"><ul aria-role="menu"><li> <a href="/"><picture><img width="35px" src="/content/dam/singapore/marinabaysands/master/main/images/revamp_logo.svg"/></picture> <picture className="gold-logo"> <svg xmlns="http://www.w3.org/2000/svg" width="35" viewBox="0 0 52.915 25.894"> <g id="logo" transform="translate(-212.454)"> <path id="Path_13" data-name="Path 13" d="M832.256,56.128s0-.128-.092-.128H779.445s-.147.055-.092.146c.292.548,1.572,2.175,5.117,2.175h3.472a.33.33,0,0,1,.237.128,38.328,38.328,0,0,1,4.331,10.818,43.088,43.088,0,0,1,1.115,12.517.105.105,0,0,0,.109.11h7.639s.2-12.993-2.431-23.573h3.6s1.407,6.981,1.407,23.573h7.731c.657-15.989,1.68-23.573,1.68-23.573h3.6c-2.5,9.813-2.7,23.573-2.7,23.573h7.639s.109-.037.109-.11a45.965,45.965,0,0,1,1.1-12.536,30.227,30.227,0,0,1,4.24-10.379c.219-.329.4-.566.567-.566h.913a4.1,4.1,0,0,0,3.436-2.193Z" transform="translate(-566.886 -56)" fill="#a9976d"></path> </g> </svg> </picture></a> </li>
    //         <li className="dyCurrentTab">
    //             <a href="/hotel.html" aria-label="Stay" data-mbs_event_id="mbs_event_web_1" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_textlink_sidebar" data-event_label="na:Stay">
    //                 Stay
    //                 <span></span>
    //             </a>
                
    //         </li>
        
    //         <li>
    //             <a href="/shopping.html" aria-label="Shop" data-mbs_event_id="mbs_event_web_1" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_textlink_sidebar" data-event_label="na:Shop">
    //                 Shop
    //                 <span></span>
    //             </a>
                
    //         </li>
        
    //         <li>
    //             <a href="/restaurants.html" aria-label="Dine" data-mbs_event_id="mbs_event_web_1" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_textlink_sidebar" data-event_label="na:Dine">
    //                 Dine
    //                 <span></span>
    //             </a>
                
    //         </li>
        
    //         <li>
    //             <a href="/see-and-do.html" aria-label="See &amp; Do" data-mbs_event_id="mbs_event_web_1" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_textlink_sidebar" data-event_label="na:See &amp; Do">
    //                 See &amp; Do
    //                 <span></span>
    //             </a>
                
    //         </li>
        
    //         <li>
    //             <a href="/guides/exceptional-experiences/whats-on-at-mbs.html" aria-label="What's On" data-mbs_event_id="mbs_event_web_1" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_textlink_sidebar" data-event_label="na:What's On">
    //                 What's On
    //                 <span></span>
    //             </a>
                
    //         </li>
        
    //         <li>
    //             <a href="/more.html" aria-label="More" data-mbs_event_id="mbs_event_web_1" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_textlink_sidebar" data-event_label="na:More">
    //                 More
    //                 <span></span>
    //             </a>
                
    //         </li>
    //     </ul><div className="button__container--reserve button__container"> <a href="/booking/search.html" aria-label="Reserve" className="button__reserve cmp-button" target="_blank" data-mbs_event_id="mbs_event_web_3" data-event_name="engagement_click" data-event_category="Engagement" data-event_action="click_button_" data-event_label="na : Reserve"> <span>Reserve</span> </a> </div></div>
        
    // </div>

<nav className="navbar navbar-expand-lg navbar-dark bg-dark">
  <a className="navbar-brand" href="#">
    <img src={require('../../../resources/logo.svg').default} alt="Hotel Name" width="120" height="100" />
  </a>
  <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span className="navbar-toggler-icon"></span>
  </button>

  <div className="collapse navbar-collapse" id="navbarSupportedContent">
    <ul className="navbar-nav ml-auto">
      <li className="nav-item active">
        <a className="nav-link" href="/">Home <span className="sr-only">(current)</span></a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Rooms</a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Dining</a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Events</a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">Contact</a>
      </li>
    </ul>
  </div>
</nav>


//     <div className="header">
//   <div className="logo">
//     <img src="/content/download.jpg" alt="Hotel Logo" width="35px"/>
//   </div>
//   <nav className="navigation">
//     <ul>
//       <li><a href="/">Home</a></li>
//       <li><a href="/rooms">Rooms</a></li>
//       <li><a href="/dining">Dining</a></li>
//     </ul>
//   </nav>
//   <div className="reservation">
//     <a href="/booking" className="reserve-button">Book Now</a>
//   </div>
// </div>
    )
}
export default Header;