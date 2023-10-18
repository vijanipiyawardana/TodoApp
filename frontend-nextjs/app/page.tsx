import { Todo } from "./components/Todo";
import { MakeTodo } from "./components/MakeTodo";

export default async function Home() {
  return (
   <>
    <MakeTodo/>
    <Todo/>
   </>
  )
}
