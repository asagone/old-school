import { Student } from "@/interfaces";

export async function fetchStudents(): Promise<Student[]> {
  const url = "http://localhost:8080/students"
 
  await new Promise(resolve => setTimeout(resolve, 3000));

  const response = await fetch(url);

  const object = await response.json();

  if(!object) {
    throw new Error(object.message);
  }

  return object.data;
}