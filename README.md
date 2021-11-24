# TK1-EX1
Please run the program using 2 (or more) command prompt, one for server, one (or more) for client.

For the server:
> ./gradlew runServerApp

For the client:
> ./gradlew runClientApp

DO NOT RUN BOTH CLIENT AND SERVER ON THE SAME COMMAND PROMPT!
-------------------------
When editing/creating flights, please follow the below datetime format:
> YYYY-MM-DD (for "original date" field only)
> YYYY-MM-DD HH:MM:SS

`Check-in counters` field is `List<Integer>` type.
`Gates` field is `List<String>` type.
`Terminal` field is `integer` type.
All date/time fields are `LocalDateTime`/`LocalDate` type.
While all the other fields are `string` type.

Please put "TK" into either the arrival or departure airport, since the system is served for virtual TK airport.

Please put the information on only the departure and check-in fields, if your flight is a departure flight.

When using the editing/creating window, use "cancel" to close the window, instead of "X".
Otherwise both editing window and flight list window will be closed.

Cells in table are in fact editable, but this was a price for enabling table to detect which row the user is selecting.
But it won't affect the value of the field.
