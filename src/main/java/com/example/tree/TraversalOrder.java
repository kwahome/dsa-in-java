package com.example.tree;

/**
 * An enumeration of possible DFS traversal orders.
 */
public enum TraversalOrder {
    // Level by level traversal
    // From the leftmost to the rightmost
    LEVEL_ORDER,

    // L -> N -> R
    IN_ORDER,

    // N -> L -> R
    PRE_ORDER,

    // L-> R-> N
    POST_ORDER,

    // Level by level traversal
    // From the rightmost to the leftmost
    REVERSE_LEVEL_ORDER,

    // R -> N -> L
    REVERSE_IN_ORDER,

    // N -> R -> L
    REVERSE_PRE_ORDER,

    // R->L->N
    REVERSE_POST_ORDER,
}
