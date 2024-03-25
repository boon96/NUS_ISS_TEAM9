import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AppRoutes from './routes';
import HotelHome from './modules/home/login';
import { HotelBooking } from './modules/hotel/booking';
import Hotel from './modules/hotel/hotel';
//  import Hotel from './modules/hotel/Hotel';
import Header from './modules/shared/header/header';
import 'bootstrap/dist/css/bootstrap.min.css';
import ContactUsPage from './modules/home/contactUs';
import AboutUsPage from './modules/home/aboutUs';
import HotelConfirmation from './modules/hotel/confirmation';
import CreateAccount from './modules/home/create';
import SummaryPage from './modules/hotel/summary';
import SearchBooking from './modules/hotel/searchBooking';

export const App = () => {
  const baseHref = document.querySelector('base')?.getAttribute('href')?.replace(/\/$/,'');
  return (
    <div className="App">
      {/* <h1>Hotel Name</h1> */}
      <Header/>
      <BrowserRouter basename={baseHref}>
        <Routes>
        {/* <Route path="/" element={<HotelHome />} /> */}
        <Route path="/" element={<HotelBooking/> }/>
        <Route path="/hotel" element={<Hotel/>}/>
        <Route path="/login" element={<HotelHome />} />
        <Route path="/contactus" element={<ContactUsPage />} />
        <Route path="/aboutus" element={<AboutUsPage />} />
        <Route path="/hotel/confirmation" element={<HotelConfirmation />} />
        <Route path="/register" element={<CreateAccount />} />
        <Route path="/summary" element={<SummaryPage />} />
        <Route path="/search" element={<SearchBooking />} />
          {/* <AppRoutes /> Use AppRoutes directly */}
        </Routes>
      </BrowserRouter>
    </div>
  );
};
export default App;