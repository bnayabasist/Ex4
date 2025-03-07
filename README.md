# Object-Oriented Spreadsheet Functionality Extension

## Overview
This project extends an existing object-oriented spreadsheet application by adding support for **Range2D**, mathematical functions (**min, max, sum, average**), and a conditional **if** function. These additions enhance the spreadsheet's capabilities by allowing more complex calculations and logical operations.

## Features Implemented
### 1. **Range2D**
- Represents a range of cells (e.g., `A1:C5`).
- Defined as `<Index2D_a:Index2D_b>`.
- Includes all cells between the two indices.
- Example: `A1:C5` consists of **15 cells**.

### 2. **Mathematical Functions**
- **Supported functions:** `min`, `max`, `sum`, `average`.
- Format: `=min(A1:C5)`, `=sum(B1:B4)`, etc.
- Each cell in the range must have a computable numerical value.
- Returns a computed result based on the values in the specified range.
- **Error Handling:** If a function is used incorrectly (e.g., wrong format), a `FUNC_ERR` is assigned to the cell.

### 3. **IF Function**
- Format: `=if(<condition>,<if-true>,<if-false>)`.
- **Condition Format:** `Formula1 op Formula2`.
- **Supported operators:** `<, >, ==, <=, >=, !=`.
- `if-true` and `if-false` can be any valid cell content (text, number, formula, function, or nested if-statements).
- **Error Handling:**
  - If the format is incorrect, the cell is assigned `IF_ERR`.
  - If there is a self-reference cycle (e.g., `A0:=if(A0>3,2,4)`), the cell is also assigned `IF_ERR`.

### 4. **Error Handling**
- `IF_ERR` for invalid `if` statements.
- `FUNC_ERR` for incorrectly formatted function calls.

### 5. **Save & Load Support**
- The save and load functionality has been modified to support `Range2D`, `if` functions, and mathematical operations.

## Example Usage
### Valid Inputs:
```plaintext
=if(1<2,1,2)       # Returns 1
=if(A1>2, big, small)  # Evaluates based on A1's value
=if(A1*A2 != A3/(2-A1), =A2+2, =A1+1)  # Computes a conditional formula
```
### Invalid Inputs (will trigger `IF_ERR`):
```plaintext
=if(1,2,3)       # Invalid condition format
=if(A1>1, 1 )    # Missing 'if-false' argument
=if(A1>A2,  =(A1, 12)  # Incorrect function syntax
```

