package tddmicroexercises.turnticketdispenser

object GlobalTurnNumberSequence : TurnNumberSequence {
    private var turnNumber = 0

    override val nextTurnNumber: Int
        get() = turnNumber++
}
