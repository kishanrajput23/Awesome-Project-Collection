const Footer = () => {
  return (
    <footer className="border">
      <div className="container text-center py-5 text-gray-700">
        Create by{" "}
        <a
          href="https://devocoe.in"
          className="hover:underline"
          target={"_blank"}
          rel="noreferrer"
        >
          devocoe
        </a>{" "}
        with <span className="text-red-500">❤</span>
      </div>
    </footer>
  );
};

export default Footer;
