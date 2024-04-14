import type { Metadata } from "next";
import { EB_Garamond } from "next/font/google";
import "../styles/global.css";
import Header from "@/components/header";

const eb_garamond = EB_Garamond({ subsets: ["latin"], weight: ["700"] });

export const metadata: Metadata = {
  title: "Old School",
  description: "Site description.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={eb_garamond.className}>
        <Header />
        {children}
        </body>
    </html>
  );
}
