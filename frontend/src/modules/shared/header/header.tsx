import React, { useState, useEffect } from "react";
import { Storage } from 'react-jhipster';

export const Header = () => {

  const isLogin = Storage.session.get('customer');
  const [userLoggedIn, setUserLoggedIn] = useState(false);

  useEffect(() => {
    if (isLogin) {
      setUserLoggedIn(true);
      console.log(userLoggedIn);
      console.log("got user navbar");
      console.log(isLogin.name);
    }
    else {
      setUserLoggedIn(false); // Update userLoggedIn state when user is not logged in
    }
  }, [userLoggedIn]);

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <a className="navbar-brand" href="/">
        <img src={require('../../../resources/logo.svg').default} alt="Hotel Name" width="120" height="100" />
      </a>
      <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav ml-auto">
          <li className="nav-item active">
            <a className="nav-link" href="/">Home </a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/aboutus">About Us</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/contactus">Contact</a>
          </li>
        </ul>
        {/* Move these items to the right */}

        {!userLoggedIn ? (

          <ul className="navbar-nav">
            <li className="nav-item">
              <a className="nav-link" href="/register">Register</a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="/login">Sign in</a>
            </li>
            {/* End of items to move */}
          </ul>
        ) : (
          <span style={{ color: 'lime' }}>Hello {isLogin.name}</span>
        )}
      </div>
    </nav>
  )
}
export default Header;