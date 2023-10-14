import { useQuery } from "@tanstack/react-query"
import { TodoCard } from "./TodoCard";
import axios from 'axios';

export type todoType = {
    id: string;
    title: string;
    addedDate: string;
    status: string;
}

export const Todo = () => {

    const fetchTodos = () => {
        axios.get("http://localhost:8080/api/todo")
    }

    const { data: todos, isLoading } = useQuery({
        queryFn: () => fetchTodos(),
        queryKey: ["todos"]
    });

    if (isLoading) {
        return <div>Loading...</div>
    }
    
    return (
        <div>
            { todos?.map((todo) => {
                return <TodoCard key={todo.id} todo={todo}/>
            })}
        </div>
    )
}
