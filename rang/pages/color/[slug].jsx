import { toast } from "react-toastify";
import colors from "../../data/colors";

const color = ({ color }) => {
  const copyColorCode = (colorCode) => {
    console.log(colorCode);
    window.navigator.clipboard
      .writeText(colorCode)
      .then(() => {
        toast.success("Copied to Clipboard");
      })
      .catch((err) => {
        toast.error("Failed to copy");
      });
  };

  return (
    <main className="container sm:my-20  my-10">
      <div className="sm:p-12 p-6 shadow-2xl rounded-2xl">
        <h5 className="text-3xl mb-6">{color.name} </h5>

        <div className="grid gap-2 lg:grid-cols-5 sm:grid-cols-3">
          {color.colors.map((item, index) => {
            return (
              <div
                key={index}
                onClick={() => {
                  copyColorCode(item.colorCode);
                }}
                className={`rounded-md px-14 py-32 relative  cursor-pointer hover:scale-95 transition-transform ${
                  item.isPrimary && "col-span-2"
                }`}
                style={{
                  backgroundColor: item.colorCode,
                }}
              >
                {/* hover button  */}
                <div className="w-full absolute top-0 left-0  transition-opacity opacity-0 hover:opacity-100 h-full grid place-items-center">
                  <span
                    style={{ backgroundColor: "#ffffff36" }}
                    className="text-white shadow-2xl sm:text-sm text-xs sm:px-4 sm:py-2  rounded"
                  >
                    Copy
                  </span>
                </div>
                {/* hover button  */}
              </div>
            );
          })}
        </div>
      </div>
    </main>
  );
};

export default color;

export function getStaticPaths() {
  const paths = colors.map((color) => ({
    params: { slug: color.slug },
  }));
  return {
    paths,
    fallback: false,
  };
}

export const getStaticProps = ({ params: { slug } }) => {
  const color = colors.filter((e) => e.slug === slug)[0];
  return {
    props: {
      color,
    },
  };
};
