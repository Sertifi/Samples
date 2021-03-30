using System.Collections.Generic;

namespace RestAndJsonEventPushSubscriber.Models
{
    /// <summary>
    /// The event notification object that gets sent when the event triggers.
    /// </summary>
    public class NotificationEvent
    {
        /// <summary>
        /// A security token for security verification purposes.
        /// </summary>
        public string SecurityToken { get; set; }

        /// <summary>
        /// A password for security verification purposes.
        /// </summary>
        public string Password { get; set; }

        /// <summary>
        /// The Type of event that triggered this notification.
        /// </summary>
        public EventType EventTypeIdField { get; set; }

        /// <summary>
        /// A unique id for this event.  Useful if there is an error to track down with Sertifi support.
        /// </summary>
        public long EventIdField { get; set; }

        /// <summary>
        /// The time that the event was triggered.
        /// </summary>
        public System.DateTime EventTimeField { get; set; }

        /// <summary>
        /// A list of Event parameters that contains data relevant to the event.
        /// These parameters can be subscribed or unsubscribed to on an individual basis through Sertifi.
        /// </summary>
        public List<NotificationEventParameter> EventParametersField { get; set; }
    }
}