import Link from "next/link";

const Card = ({ color }) => {
  return (
    <Link href={`/color/${color.slug}`}>
      <a>
        <div className="sm:p-6 hover:shadow-xl hover:scale-95 transition-all p-4 shadow-2xl rounded-2xl">
          <h5 className="text-xl mb-6">{color.name}</h5>

          <div className="grid gap-2 grid-cols-2">
            {color.colors.slice(0, 4).map((item, index) => {
              return (
                <div
                  key={index}
                  className="rounded-md p-14"
                  style={{
                    backgroundColor: item.colorCode,
                  }}
                ></div>
              );
            })}
          </div>
        </div>
      </a>
    </Link>
  );
};

export default Card;
