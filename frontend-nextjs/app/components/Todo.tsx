"use client"

import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import { TodoCard } from "./TodoCard";

export interface Todo {
    id: string;
    title: string;
    addedDate: string;
    status: string;
}

export const Todo = () => {

    const { data, isLoading, isError } = useQuery({
        queryKey: ["todos"],
        queryFn: async () => {
            const { data } = await axios.get("http://localhost:8080/api/todo");
            console.log(data);
            return data as Todo[];
        }
    });

    if (isLoading) {
        return <div>Loading...</div>
    }

    if (isError) {
        return <div>Error...</div>
    }


    return (
        <div>
             {data?.map((todo: Todo) => {
                return <TodoCard key={todo.id} todoItem={todo} />
            })}
        </div>
    )
}
