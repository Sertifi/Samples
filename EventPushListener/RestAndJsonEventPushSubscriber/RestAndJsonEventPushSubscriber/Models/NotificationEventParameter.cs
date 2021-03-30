namespace RestAndJsonEventPushSubscriber.Models
{
    /// <summary>
    /// Parameters specific to the event that triggered the notification.
    /// </summary>
    public class NotificationEventParameter
    {
        /// <summary>
        /// The name of the parameter field.
        /// </summary>
        /// <example>PaymentName</example>
        public string NameField { get; set; }

        /// <summary>
        /// The value of the parameter.
        /// </summary>
        /// <example>Down payment</example>
        public string ValueField { get; set; }

    }
}