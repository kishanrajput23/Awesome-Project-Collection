import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import "../styles/globals.css";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function MyApp({ Component, pageProps }) {
  return (
    <>
      <Navbar />
      <ToastContainer
        position="bottom-right"
        autoClose={1000}
        hideProgressBar={true}
      />
      <Component {...pageProps} />
      <Footer />
    </>
  );
}

export default MyApp;
