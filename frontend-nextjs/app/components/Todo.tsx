"use client"

import { useQuery } from "@tanstack/react-query";
import axios from "axios";

export interface Todo {
    id: string;
    title: string;
    addedDate: string;
    status: string;
}

export const Todo = () => {

  const {} = useQuery({
    queryKey: ["todos"],
    queryFn: async () => {
        const {data} = await axios.get("http://localhost:8080/api/todo")
        console.log(data)
    }
  })

  return (
    <div>Todo</div>
  )
}
