"use client";

import { useEffect } from "react";
import { fetchStudents } from "@/utils/api";

/**
 * @Development branch.
 * Front-end @version 0.1
 */
export default function Home() {
  useEffect(() => {
    const fetchApi = async () => {
      const students = await fetchStudents();

      console.log(students);
    }

    fetchApi();
  }, []);

  return (
    <main>
      <span>Nextjs</span>
    </main>
  );
}
