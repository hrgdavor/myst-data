TODO reevaluate integration with https://immutables.github.io/

TODO implement optional jackson support

TODO optional EnumSetter and EnumGetter

 

Enum as column metadata
=======================

 

\* all columns of an entity are represented by an Enum constant

\* order of columns and position is governed by the Enum

\* an array representation of data is well defined

\* EnumSet can be used to represent changes

\* EnumMap could be used in some scenarios

\* enum can be expanded to give more information(like column’s Java type or SQL
type)

 

Enum and Object[] combo for handling changes and creating new Objects

 

get(Enum):value and set(Enum,value) for updates backed either by array or
generated object

 

todo microbenchmark to comapre performance (to see if both are viable, or one is
much better than other: array or generated-object )

 

 

 
