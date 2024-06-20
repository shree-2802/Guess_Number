"use client";
import { useRouter } from "next/navigation";
import { guess } from "./api";
import { CODE } from "./appConstants";
import styles from "./page.module.css";
import { useState } from "react";

export default function Home() {
  const router = useRouter()
  const [input, setInput] = useState<string | number>("");
  const onSubmit = async (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
    if (!input)
      return alert("Enter a valid number");
    if (typeof (input) === "number") {
      const { data: data } = await guess(input);
      console.log(data);
      alert(data.message);
      if (data?.code === CODE.WIN || data.code === CODE.LOSS) {
        !confirm('Do you wanna play another game?') && router.push("thanks")
      }
      setInput("");
    }
  }
  return (
    <main className={styles.main}>
      <h2>Guess the number</h2>
      <input className={styles.input} type="number" placeholder="Enter a number 1-99" value={input == 0 ? "" : input} onChange={e => setInput(Number(e.target.value))} />
      <button type="submit" className={styles.button} onClick={(e) => onSubmit(e)}>Guess Me</button>
    </main>
  );
}
