import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query"
import { TodoCard } from "./TodoCard";
import axios from 'axios';
import { useState } from "react";

export type TodoType = {
    id: string;
    title: string;
    addedDate: string;
    status: string;
}

export type AddTodoType = {
    title: string;
}

export const Todo = () => {

    const queryClient = useQueryClient();
    const [titleText, setTitleText] = useState("");

    const fetchTodos = async () => {
        const response = await axios.get<TodoType[]>("http://localhost:8080/api/todo");
        return response.data;
    }

    const addTodo = async (data: AddTodoType) => {
        const response = await axios.post("http://localhost:8080/api/todo", data);
        return response.data;
    }

    const { data, isLoading } = useQuery({
        queryFn: fetchTodos,
        queryKey: ["todos"]
    });

    const { mutateAsync: addTodoMutation } = useMutation({
        mutationFn: addTodo,
        onSuccess: () => {
            queryClient.invalidateQueries(["todos"]);
        }
    });

    if (isLoading) {
        return <div>Loading...</div>
    }

    return (
        <div>
            <div>
                <input type="text" onChange={(e) => setTitleText(e.target.value)} value={titleText} />
                <button onClick={async () => {
                    try{
                        await addTodoMutation({title: titleText});
                        setTitleText("");
                    } catch (e) {
                        console.log(e);
                    }
                }}>Add Todo</button>
            </div>
            {data?.map((todo: TodoType) => {
                return <TodoCard key={todo.id} todoItem={todo} />
            })}
        </div>
    )
}
