import Head from "next/head";
import Card from "../components/Card";
import colors from "../data/colors";

export default function Home({ colors }) {
  return (
    <div>
      <Head>
        <title>Rang</title>
        <meta
          name="description"
          content="an online colour palette that includes every Google Material UI colour."
        />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      {/* main */}
      <main className="container sm:my-20  my-10 grid xl:grid-cols-4 lg:grid-cols-3 md:grid-cols-2 grid-cols-1 sm:gap-8 gap-6">
        {colors.map((color, index) => {
          return <Card color={color} key={index} />;
        })}
      </main>
    </div>
  );
}

export const getStaticProps = () => {
  return {
    props: {
      colors,
    },
  };
};
