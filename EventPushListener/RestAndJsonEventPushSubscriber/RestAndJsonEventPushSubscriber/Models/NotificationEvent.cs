namespace RestAndJsonEventPushSubscriber.Models
{
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name = "NotificationEvent", Namespace = "http://apps.sertifi.net/services/subscribers")]
    [System.SerializableAttribute()]
    public class NotificationEvent : object, System.ComponentModel.INotifyPropertyChanged
    {
        /// <summary>
        /// A security token for security verification purposes.
        /// </summary>
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string SecurityTokenField;

        /// <summary>
        /// A password for security verification purposes.
        /// </summary>
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string PasswordField;

        /// <summary>
        /// The Type of event that triggered this notification.
        /// </summary>
        private EventType EventTypeIdField;

        /// <summary>
        /// A unique id for this event.  Useful if there is an error to track down with Sertifi support.
        /// </summary>
        private long EventIdField;

        /// <summary>
        /// The time that the event was triggered.
        /// </summary>
        private System.DateTime EventTimeField;

        /// <summary>
        /// A list of Event parameters that contains data relevant to the event.
        /// These parameters can be subscribed or unsubscribed to on an individual basis through Sertifi.
        /// </summary>
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.Collections.Generic.List<NotificationEventParameter> EventParametersField;

        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue = false)]
        public string SecurityToken
        {
            get
            {
                return this.SecurityTokenField;
            }
            set
            {
                if ((object.ReferenceEquals(this.SecurityTokenField, value) != true))
                {
                    this.SecurityTokenField = value;
                    this.RaisePropertyChanged("SecurityToken");
                }
            }
        }

        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue = false, Order = 1)]
        public string Password
        {
            get
            {
                return this.PasswordField;
            }
            set
            {
                if ((object.ReferenceEquals(this.PasswordField, value) != true))
                {
                    this.PasswordField = value;
                    this.RaisePropertyChanged("Password");
                }
            }
        }

        [System.Runtime.Serialization.DataMemberAttribute(IsRequired = true, Order = 2)]
        public EventType EventTypeId
        {
            get
            {
                return this.EventTypeIdField;
            }
            set
            {
                if ((this.EventTypeIdField.Equals(value) != true))
                {
                    this.EventTypeIdField = value;
                    this.RaisePropertyChanged("EventTypeId");
                }
            }
        }

        [System.Runtime.Serialization.DataMemberAttribute(IsRequired = true, Order = 3)]
        public long EventId
        {
            get
            {
                return this.EventIdField;
            }
            set
            {
                if ((this.EventIdField.Equals(value) != true))
                {
                    this.EventIdField = value;
                    this.RaisePropertyChanged("EventId");
                }
            }
        }

        [System.Runtime.Serialization.DataMemberAttribute(IsRequired = true, Order = 4)]
        public System.DateTime EventTime
        {
            get
            {
                return this.EventTimeField;
            }
            set
            {
                if ((this.EventTimeField.Equals(value) != true))
                {
                    this.EventTimeField = value;
                    this.RaisePropertyChanged("EventTime");
                }
            }
        }

        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue = false, Order = 5)]
        public System.Collections.Generic.List<NotificationEventParameter> EventParameters
        {
            get
            {
                return this.EventParametersField;
            }
            set
            {
                if ((object.ReferenceEquals(this.EventParametersField, value) != true))
                {
                    this.EventParametersField = value;
                    this.RaisePropertyChanged("EventParameters");
                }
            }
        }

        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;

        protected void RaisePropertyChanged(string propertyName)
        {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null))
            {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
}