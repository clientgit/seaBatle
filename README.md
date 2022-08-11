## Sea Battle Game
------------------------------------------
The game uses a square field of cells, on which before the start of the game, each of the players places their ships.  
_Example:_ 8 ships on the field 10x10
```
  __0__1__2__3__4__5__6__7__8__9__
0 | @  -  @  @  -  -  -  -  -  - |
1 | @  -  -  -  -  -  @  @  -  - |
2 | @  -  -  -  -  -  -  -  -  - |
3 | @  -  -  -  -  -  -  -  @  - |
4 | -  -  -  -  -  @  -  -  -  - |
5 | -  -  -  -  -  @  -  -  -  - |
6 | -  @  @  @  -  @  -  -  -  - |
7 | -  -  -  -  -  -  -  -  -  - |
8 | -  -  -  -  -  @  @  @  @  - |
9 | @  -  -  -  -  -  -  -  -  - |
```
### About the task:
- Square playing field measuring 10 by 10 cells predetermined.
- All cells of the field are initialized with the boolean value false.
- Coordinates of the field are numbered from zero.
- It is necessary to check the conditions:
    - The ship has no bends (the width of the ship is always one).
    - The length of the ship is not more than four.
    - Ships can be located to the borders of the field, but can't touch each other, even with the corners of their cells.


Cell  a ship is like a pair of coordinates of this cell on the field:
```scala
type Point = (Int, Int)
``` 
The playing field can be represented as a two-dimensional array, storing for each cell a boolean value indicating whether a ship is on that cell:
```scala
type Field = Vector[Vector[Boolean]]
```

Interpretation of the ship as a list of points:
```scala
type Ship = List[Point]
```

Interpretation the set of all ships on the field as an associative array. By the string key (ship's name) the list of ship's points is found.
```scala
type Fleet = Map[String, Ship]
```

The game is described by its field and list of ships:
```scala
type Game = (Field, Fleet)
```
### Input:
1. First line this number of ships that a player wants to add to the field:
```console
size of the Fleet: 1
```
2. Second line this name of the ship and its size:
```console
name and size of the Ship number 1 (separated by a space): Starship 4
```
3. Third line, etc., are the coordinates of the ship:
```console
coordinate: 4 1
coordinate: 4 2
coordinate: 4 3
coordinate: 4 4
```
### Output:
1. Names of ships that were successfully placed on the field:
```console
Spaceship -> List((4,1), (4,2), (4,3), (4,4))
```
2. The playing field with placed ships:
```console
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  @  @  @  @  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
 -  -  -  -  -  -  -  -  -  -
```

