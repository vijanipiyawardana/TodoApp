import { useQuery } from "@tanstack/react-query"
import { TodoCard } from "./TodoCard";
import axios from 'axios';

export type TodoType = {
    id: string;
    title: string;
    addedDate: string;
    status: string;
}

export const Todo = () => {

    const fetchTodos = async () => {
        const response = await axios.get<TodoType[]>("http://localhost:8080/api/todo");
        return response.data;
    }

    const { data, isLoading } = useQuery({
        queryFn: () => fetchTodos(),
        queryKey: ["todos"]
    });

    if (isLoading) {
        return <div>Loading...</div>
    }
    
    return (
        <div>
            { data?.map((todo: TodoType) => {
                return <TodoCard key={todo.id} todoItem={todo}/>
            })}
        </div>
    )
}
