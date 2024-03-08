import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AppRoutes from './routes';
import HotelHome from './modules/home/login';
import { HotelBooking } from './modules/hotel/booking';
import Header from './modules/shared/header/header';
import 'bootstrap/dist/css/bootstrap.min.css';

export const App = () => {
  const baseHref = document.querySelector('base')?.getAttribute('href')?.replace(/\/$/,'');
  return (
    <div className="App">
      {/* <h1>Hotel Name</h1> */}
      <Header/>
      <BrowserRouter basename={baseHref}>
        <Routes>
        <Route path="/" element={<HotelHome />} />
        <Route path="/bookings" element={<HotelBooking/> }/>
          {/* <AppRoutes /> Use AppRoutes directly */}
        </Routes>
      </BrowserRouter>
    </div>
  );
};
export default App;
