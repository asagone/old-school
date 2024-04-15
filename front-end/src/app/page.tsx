"use client";

import { useEffect, useState } from "react";
import { fetchStudents } from "@/utils/api";
import { Student } from "@/interfaces";

/**
 * @Development branch.
 * Front-end @version 0.1
 */
export default function Home() {
  const [students, setStudents] = useState<Student[]>([]);

  useEffect(() => {
    const fetchApi = async () => {
      const students: Student[] = await fetchStudents();
      if (!students) {
        return null;
      }

      const sorted = students.sort((a: Student, b: Student) => {
        return a.studentName.localeCompare(b.studentName);
      });

      setStudents(sorted);
    };

    fetchApi();
  }, []);

  return (
    <main>
      {students.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>Student Name</th>
              <th>Average</th>
              <th>English</th>
              <th>Portuguese</th>
              <th>Japanese</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s: Student) => {
              return (
                <tr key={s.id}>
                  <td>{s.studentName}</td>
                  <td>{s.averageGrade}</td>
                  <td>{s.englishGrade}</td>
                  <td>{s.portugueseGrade}</td>
                  <td>{s.japaneseGrade}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      ) : (
        <p>Loading...</p>
      )}
    </main>
  );
}
