package com.itsc1;

public class ToDoList {
    // Task Class
    public class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            completed = true;
        }
    }

    // Node Class
    public class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // ToDoList Class
    public class ToDolist {
        private Node head;

        public ToDolist() {
            head = null;
        }

        public void addToDo(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void markToDoAsCompleted(String title) {
            Node current = head;
            while (current != null) {
                if (current.task.getTitle().equals(title)) {
                    current.task.markCompleted();
                    return;
                }
                current = current.next;
            }
        }

        public void viewToDoList() {
            Node current = head;
            while (current != null) {
                System.out.println("Title: " + current.task.getTitle());
                System.out.println("Description: " + current.task.getDescription());
                System.out.println("Completed: " + current.task.isCompleted());
                System.out.println();
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        ToDoList.ToDolist toDoList = todoList.new ToDolist();

        ToDoList.Task task1 = todoList.new Task("Task 1", "This is task 1");
        ToDoList.Task task2 = todoList.new Task("Task 2", "This is task 2");
        ToDoList.Task task3 = todoList.new Task("Task 3", "This is task 3");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);

        toDoList.viewToDoList();

        toDoList.markToDoAsCompleted("Task 2");

        toDoList.viewToDoList();
    }
}