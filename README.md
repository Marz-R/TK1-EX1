# TK1-EX1
Execution
-------------------------
Please execute Gradle inside `tk1-ex1` folder, not TK1-EX1 folder.

Run the program using 2 (or more) command prompt, one for server, one (or more) for client.

For the server:
> ./gradlew runServerApp

For the client:
> ./gradlew runClientApp

DO NOT run both server and client on the SAME command prompt!


Edit and Create
-------------------------
When editing/creating flights, please follow the below datetime format:
> YYYY-MM-DD (for "original date" field only)
> 
> YYYY-MM-DD HH:MM:SS

`Check-in counters` field is `List<Integer>` type.

`Gates` field is `List<String>` type.

`Terminal` field is `integer` type.

All date/time fields are `LocalDateTime`/`LocalDate` type.

While all the other fields are `string` type.

Please put `TK` into either the arrival or departure airport, since the system is served for virtual TK airport.

Please put the information on only the departure and check-in fields, if your flight is a departure flight.
Please put the information on only the arrival fields, if your flight is an arrival flight.

Other operations
-------------------------
When using the editing/creating window, use `cancel` to close the window, instead of "X".
Otherwise both editing window and flight list window will be closed.

Cells in table are in fact editable, but this was a price for enabling table to detect which row the user is selecting.
But it won't affect the value of the field.
