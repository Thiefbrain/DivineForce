DivineForce
===========

This is the main Divine Force repository. This mod is open source, licensed under GPL v2.

Coding conventions
===========
These are the coding conventions for this mod:

1. Each Class has to overwrite Object.toString(), Object.hashCode() and Object.equals()
2. Block-brackets have to be on a single line (not: `if (...) {`)
3. Each function and class- or instance-variables as well as classes should have a java doc comment
4. Outputs should be internationalized
5. Lines have a max-length of 160 characters (including spaces)

Packets
===========
All packets of this mod are built like this:

    +-----------+--------+-------------+
    | Packet ID | Length | Packet data |
    | (1 byte)  |        |             |
    +-----------+--------+-------------+
