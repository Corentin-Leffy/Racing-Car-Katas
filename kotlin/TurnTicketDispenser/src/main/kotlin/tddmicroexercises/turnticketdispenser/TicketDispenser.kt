package tddmicroexercises.turnticketdispenser

class TicketDispenser(
    private val turnNumberSequence: TurnNumberSequence = GlobalTurnNumberSequence
) {
    val turnTicket: TurnTicket
        get() = TurnTicket(turnNumberSequence.nextTurnNumber)
}
