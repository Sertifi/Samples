namespace RestAndJsonEventPushSubscriber.Models
{
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name = "NotificationEventParameter", Namespace = "http://apps.sertifi.net/services/subscribers")]
    [System.SerializableAttribute()]
    public partial class NotificationEventParameter : object, System.ComponentModel.INotifyPropertyChanged
    {
        /// <summary>
        /// The name of the parameter field.
        /// </summary>
        /// <example>PaymentName</example>
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string NameField;

        /// <summary>
        /// The value of the parameter.
        /// </summary>
        /// <example>Down payment</example>
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string ValueField;

        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue = false)]
        public string Name
        {
            get
            {
                return this.NameField;
            }
            set
            {
                if ((object.ReferenceEquals(this.NameField, value) != true))
                {
                    this.NameField = value;
                    this.RaisePropertyChanged("Name");
                }
            }
        }

        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue = false)]
        public string Value
        {
            get
            {
                return this.ValueField;
            }
            set
            {
                if ((object.ReferenceEquals(this.ValueField, value) != true))
                {
                    this.ValueField = value;
                    this.RaisePropertyChanged("Value");
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