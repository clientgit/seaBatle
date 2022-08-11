# Sea Battle Game
------------------------------------------

The game uses a square field of cells, on which before the start of the game, each of the players places their ships.  
_Example:_ 8 ships on the field 10x10
```
  __0__1__2__3__4__5__6__7__8__9__
0 | @  -  @  @  -  -  -  -  -  - |
1 | @  -  -  -  -  -  @  @  -  - |
2 | @  -  -  -  -  -  -  -  -  - |
3 | @  -  -  -  -  @  -  -  @  - |
4 | -  -  -  -  -  @  -  -  -  - |
5 | -  -  -  -  -  @  -  -  -  - |
6 | @  @  @  -  -  @  -  -  -  - |
7 | -  -  -  -  -  -  -  -  -  - |
8 | -  -  -  -  -  -  -  @  @  @ |
9 | @  -  -  -  -  -  -  -  -  - |
```

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
- first line this number of ships that a player wants to add to the field.
```console
size of the Fleet: 2
```
- second line this 
```console
name and size of the Ship: 
```
