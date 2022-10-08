import Image from "next/image";
import Link from "next/link";

const Navbar = () => {
  return (
    <nav className="shadow-md">
      <div className="container py-2">
        <Link href={"/"}>
          <a>
            <Image src="/logo.svg" alt="rang" width={90} height={50} />
          </a>
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
