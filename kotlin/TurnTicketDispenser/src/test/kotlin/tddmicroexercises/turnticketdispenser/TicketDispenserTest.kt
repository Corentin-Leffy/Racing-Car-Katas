package tddmicroexercises.turnticketdispenser

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TicketDispenserTest {
    @Test
    fun `Next ticket should be greater then the current one`() {
        val ticketDispenser = TicketDispenser()
        val currentTicket = ticketDispenser.turnTicket.turnNumber
        val nextTicket = ticketDispenser.turnTicket.turnNumber

        assertTrue(currentTicket < nextTicket)
    }

    @Test
    fun `Next ticket from a different dispenser should be greater`() {
        val currentTicket = TicketDispenser().turnTicket.turnNumber
        val nextTicket = TicketDispenser().turnTicket.turnNumber

        assertTrue(currentTicket < nextTicket)
    }

    @Test
    fun `Next ticket should be 12 if the previous ticket is 11`() {
        val nextTicket = TicketDispenser(TurnNumberSequenceAt11()).turnTicket.turnNumber

        assertEquals(12, nextTicket)
    }

    inner class TurnNumberSequenceAt11 : TurnNumberSequence {
        var currentTicket = 11
        override val nextTurnNumber: Int
            get() = ++currentTicket
    }
}