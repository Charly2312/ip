# Aples User Guide

```
       **     *******  **       ********  ******** 
      ****   /**////**/**      /**/////  **////// 
     **//**  /**   /**/**      /**      /**       
    **  //** /******* /**      /******* /********* 
   **********/**////  /**      /**////  ////////** 
  /**//////**/**      /**      /**             /** 
  /**     /**/**      /********/******** ******** 
  //      // //       //////// //////// ////////  
                Aples at your service             
 
Hello! I'm Aples
This is where you left of:
--------------------------------------------------
--------------------------------------------------
What can I do for you?
--------------------------------------------------
```

Aples is a chatbot built to help manage your tasks! There will be 3 types of task: Todo, Event, Deadline.
The are several functions to this chatbot: 'add', 'delete', 'mark', 'unmark', 'list' and 'find'. 
Have fun using it!

## Adding a Todo task

Adds a Todo task into the list

Format: `todo DESCRIPTION`

Example: `todo sleep` adds the Todo task with DESCRIPTION sleep into the list

Input:
```
todo exercise
```

Outcome: 
```
--------------------------------------------------
Got it. I've added this task:
  [T][ ]  exercise
Now you have 1 task in the list.
--------------------------------------------------
```

## Adding an Event task

Adds an Event into the list

Format: `event DESCRIPTION /from DATE_1 /to DATE_2` or `/event DESCRIPTION /from TIME_1 /to TIME_2`

Examples: 
- `event go nus /from 11am /to 1pm` will add an Event task with DESCRIPTION: go nus with TIME_1: 11am and TIME_2: 1pm
- `event holiday /from 1st April /to 2nd April` will add an Event task with DESCRIPTION: holidat with DATE_1: 1st April and DATE_2: 2nd April

Input_1:
```
/event go nus /from 11am /to 1pm
```

Outcome_1: 
```
--------------------------------------------------
Got it. I've added this task:
  [E][ ]  go nus (from: 11am to: 1pm)
Now you have 2 tasks in the list.
--------------------------------------------------
```

Input_2:
```
event holiday /from 1st April /to 2nd April
```

Outcome_2: 
```
--------------------------------------------------
Got it. I've added this task:
  [E][ ]  holiday (from: 1st April to: 2nd April)
Now you have 3 tasks in the list.
--------------------------------------------------
```

## Adding a Deadline Task

Adds a Deadline task into the list

Format: `/deadline DESCRIPTION /by DATE TIME`

- `DATE` must be in the format of `yyyy-mm-dd`
- `TIME` must be in the format of `hh:mm`

Example: `/deadline assignment /by 2025-01-01 23:59` adds the deadline task with DESCRIPTION: assignment, DATE: 2025-01-01 and TIME: 23:59

Input:
```
deadline assignment /by 2025-01-01 23:59
```

Outcome: 
```
--------------------------------------------------
Got it. I've added this task:
  [D][ ] assignment (do by: Jan 1 2025 23:59)
Now you have 4 tasks in the list.
--------------------------------------------------
```

## Listing all tasks

List all the tasks created previously

Format: `list`

Example: `list` will list down all the tasks created previously

Input:
```
list
```

Outcome: 
```
--------------------------------------------------
1. [T][ ] exercise
2. [E][ ]  go nus (from: 11am to: 1pm)
3. [E][ ] holiday (from: 1st April to: 2nd April)
4. [D][ ] assignment (do by: Jan 1 2025 23:59)
--------------------------------------------------
```

## Mark or Unmark a task

This will mark or unmark the task with the specified index

Format: `mark INDEX` or `unmark INDEX` 

Example: `mark 2` will mark the task with INDEX 2 resulting in `[X]`

Input_1:
```
mark 2
```

Outcome_1: 
```
--------------------------------------------------
Nice! I've marked this task as done:
  [E][X]  go nus (from: 11am to: 1pm)
--------------------------------------------------
```

Input_2:
```
unmark 2
```

Outcome_2:
```
--------------------------------------------------
Sadness but OK, I've marked this task as not done yet:
  [E][ ]  go nus (from: 11am to: 1pm)
--------------------------------------------------
```


## Delete a Task

List all the tasks created previously

Format: `delete INDEX`

Example: `delete 3` will delete the task with INDEX 3 in the list

Input:
```
delete 3
```

Outcome: 
```
--------------------------------------------------
Okais. I have removed this task:
 [E][ ]  holiday (from: 1st April to: 2nd April)
Now you have 3 left in the list.
--------------------------------------------------
```

## Finding a task

A user can find specific task(s) with a specific keyword

Format: `find KEYWORD`

Example: `find nus` will list all the tasks with KEYWORD: nus

Input:
```
find nus
```

Outcome: 
```
--------------------------------------------------
1. [E][ ]  go nus (from: 11am to: 1pm)
--------------------------------------------------
```

## End converation

A user can leave the chatbot and all the tasks in the list will be saved in a txt file

Format: `bye`

Example: `bye` will leave the chatbot and saving all the tasks in a txt file

Input:
```
bye
```

Outcome: 
```
--------------------------------------------------
Bye. Hope to see you again soon!
--------------------------------------------------
--------------------------------------------------
File updated successfully!
--------------------------------------------------
```
