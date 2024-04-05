// import React from 'react';
// import { render, screen } from '@testing-library/react';
// import App from './App';

// test('test for fun', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/ABC HOTEL/i);
//   expect(linkElement).toBeInTheDocument();
// });
import React from 'react';
import { render, screen } from '@testing-library/react';
import { Provider } from 'react-redux';
import getStore from './config/store';
import App from './App';

// Mock window.matchMedia
Object.defineProperty(window, 'matchMedia', {
  writable: true,
  value: jest.fn().mockImplementation(query => ({
    matches: false,
    media: query,
    onchange: null,
    addListener: jest.fn(), // You can provide a mock implementation for addListener if needed
    removeListener: jest.fn(), // You can provide a mock implementation for removeListener if needed
  })),
});

test('test for fun', () => {
  render(
    <Provider store={getStore()}>
      <App />
    </Provider>
  );
  const linkElement = screen.getByText(/ABC HOTEL/i);
  expect(linkElement).toBeInTheDocument();
});