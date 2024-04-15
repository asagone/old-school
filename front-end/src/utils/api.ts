export async function fetchStudents() {
  const url = "http://localhost:8080/students"
 
  await new Promise(resolve => setTimeout(resolve, 3000));

  const response = await fetch(url);

  const data = await response.json();

  if(!data) {
    throw new Error(data.message);
  }

  return data;
}